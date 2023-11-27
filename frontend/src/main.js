import './assets/sass/general.scss'
import "../node_modules/bootstrap/scss/bootstrap.scss";
import 'boxicons';

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(router)

app.mount('#app')
