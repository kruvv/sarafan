import Vue from 'vue'
import Vuetify from 'vuetify'
import 'api/resource'
import App from 'pages/App.vue'
import { connect } from './util/ws'
import 'vuetify/dist/vuetify.min.css'


//Проверка условия что профайл заполнен
if(frontendData.profile) {
    connect()
}

Vue.use(Vuetify)


new Vue({
    el: '#app',
    render: a => a(App)
})
