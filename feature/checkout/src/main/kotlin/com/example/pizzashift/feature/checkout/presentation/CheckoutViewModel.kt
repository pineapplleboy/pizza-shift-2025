package com.example.pizzashift.feature.checkout.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzashift.feature.checkout.domain.usecase.OrderPizzaUseCase
import com.example.pizzashift.feature.checkout.domain.usecase.ValidateDebitCardUseCase
import com.example.pizzashift.feature.checkout.domain.usecase.ValidatePhoneUseCase
import com.example.pizzashift.shared.domain.model.OrderedPizza
import com.example.pizzashift.shared.domain.model.PaymentAddress
import com.example.pizzashift.shared.domain.model.PaymentDebitCard
import com.example.pizzashift.shared.domain.model.PaymentPerson
import com.example.pizzashift.shared.domain.model.PizzaPayment
import com.example.pizzashift.shared.domain.usecase.CountPizzaPriceUseCase
import com.example.pizzashift.shared.domain.usecase.GetCartUseCase
import com.example.pizzashift.shared.domain.usecase.MakePizzaDescriptionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class CheckoutViewModel(
    private val orderPizzaUseCase: OrderPizzaUseCase,
    private val validatePhoneUseCase: ValidatePhoneUseCase,
    private val validateDebitCardUseCase: ValidateDebitCardUseCase,
    private val getCartUseCase: GetCartUseCase,
    private val countPizzaPriceUseCase: CountPizzaPriceUseCase,
    private val makePizzaDescriptionUseCase: MakePizzaDescriptionUseCase

) : ViewModel() {

    private val _state = MutableStateFlow<CheckoutState>(CheckoutState.FirstPart)
    val state: StateFlow<CheckoutState> = _state.asStateFlow()

    private fun orderPizza(payment: PizzaPayment) {
        viewModelScope.launch {
            _state.value = CheckoutState.Loading

            try {
                orderPizzaUseCase(payment)
                _state.value = CheckoutState.Success(
                    paymentPrice = payment.pizzas.sumOf { countPizzaPriceUseCase(it) }.toString(),
                    pizzasDescription = payment.pizzas.joinToString("\n") {
                        makePizzaDescriptionUseCase(
                            it
                        )
                    },
                    pizzaPayment = payment
                )
            } catch (ce: CancellationException) {
                throw ce
            } catch (ex: Exception) {
                _state.value = CheckoutState.Failure(ex.localizedMessage.orEmpty())
            }
        }
    }

    fun validateFirstPart(paymentPerson: PaymentPerson, address: PaymentAddress) {

        if (!validatePhoneUseCase(paymentPerson.phone)) {
            _state.value = CheckoutState.Failure("Номер телефона должен быть в формате 8XXXXXXXXXX")
        } else if (paymentPerson.firstName.isEmpty()) {
            _state.value = CheckoutState.Failure("Поле 'Имя' не заполнено")
        } else if (paymentPerson.lastName.isEmpty()) {
            _state.value = CheckoutState.Failure("Поле 'Фамилия' не заполнено")
        } else if (address.street.isEmpty() || address.house.isEmpty() || address.apartment.isEmpty()) {
            _state.value = CheckoutState.Failure("Недостаточно информации о адресе")
        } else {
            _state.value = CheckoutState.SecondPart
        }
    }

    private suspend fun getCart(): List<OrderedPizza> {
        return getCartUseCase()
    }

    fun validateSecondPartAndOrder(
        paymentPerson: PaymentPerson,
        address: PaymentAddress,
        card: PaymentDebitCard
    ) {
        viewModelScope.launch {
            val payment = PizzaPayment(
                pizzas = getCart(),
                person = paymentPerson,
                receiverAddress = address,
                debitCard = card
            )

            if (!validateDebitCardUseCase(payment.debitCard)) {
                _state.value = CheckoutState.Failure("Некорректные данные карты")
            } else {
                _state.value = CheckoutState.Loading

                orderPizza(payment)
            }
        }
    }

    fun goToFirstPart() {
        _state.value = CheckoutState.FirstPart
    }
}