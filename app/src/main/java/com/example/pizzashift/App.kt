package com.example.pizzashift

import android.app.Application
import com.example.pizzashift.feature.cart.di.cartModule
import com.example.pizzashift.feature.checkout.di.checkoutModule
import com.example.pizzashift.shared.di.dataModule
import com.example.pizzashift.shared.di.domainModule
import com.example.pizzashift.feature.pizza_catalog.di.pizzaCatalogModule
import com.example.pizzashift.feature.pizza_details.di.pizzaDetailsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(
                listOf(
                    dataModule,
                    domainModule,
                    pizzaDetailsModule,
                    pizzaCatalogModule,
                    cartModule,
                    checkoutModule
                )
            )
        }
    }
}