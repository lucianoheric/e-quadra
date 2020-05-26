import Vue from 'vue'
import App from './App.vue'
import VueResource from 'vue-resource';
import VueRouter from 'vue-router';
import { routes } from './routes';
import Vmodal from 'vue-js-modal'


/* registrando as classes impoadas */
Vue.use(VueResource);
Vue.use(VueRouter);
Vue.use(Vmodal)

/** roteador que com o auxílio do VueRouter recebe as rotas e às roteia */
const router = new VueRouter({ 
  routes,  
  /** 
   *  o mode: 'history' evita precisar colocar o # no navegador 
   *  ao invés de utilizar localhost:8081/#/cadastro poderá ser
   *  utilizado localhost:8081/cadastro e localhost:8081 para Home.
   */
  mode: 'history'
});

Vue.config.productionTip = false;

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')