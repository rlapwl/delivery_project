
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/OrderManager"

import Menu from "./components/Menu"
import PaymentManager from "./components/PaymentManager"

import StoreManager from "./components/StoreManager"

import ReviewManager from "./components/ReviewManager"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/Order',
                name: 'OrderManager',
                component: OrderManager
            },

            {
                path: '/Menu',
                name: 'Menu',
                component: Menu
            },
            {
                path: '/Payment',
                name: 'PaymentManager',
                component: PaymentManager
            },

            {
                path: '/Store',
                name: 'StoreManager',
                component: StoreManager
            },

            {
                path: '/Review',
                name: 'ReviewManager',
                component: ReviewManager
            },




    ]
})
