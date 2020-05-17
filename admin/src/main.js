import Vue from 'vue'
import App from './app.vue'
import router from './router'
import axios from 'axios'

Vue.config.productionTip = false;
Vue.prototype.$ajax = axios;//内置的属性，以后使用时调用这个属性

new Vue({
  router,
  render: h => h(App),
}).$mount('#app');
