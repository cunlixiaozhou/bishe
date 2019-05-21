// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
axios.defaults.headers.common['res'] = store.state.token;  
import Vue from 'vue';
import App from './App';
import ElementUI from 'element-ui/lib/index.js';
//import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import Vuex from 'vuex';
import axios from 'axios';
//import Mock from './mock'
//Mock.bootstrap();
import VueResource from 'vue-resource';
import VueRouter from 'vue-router';
//import router from './router'
import routes from './routes';
import store from './vuex/store'
Vue.use(ElementUI);
Vue.use(VueRouter);
Vue.use(Vuex);

Vue.use(VueResource);
const router = new VueRouter({  
//mode: "history",  
routes  
});  
// router.beforeEach((to, from, next) => {
// 	if (to.matched.some(record => record.meta.requireAuth)){
// 	let token = sessionStorage.getItem('token');
// 	 if (to.path == '/login') {
//     sessionStorage.removeItem('token');
//   }
// let user = JSON.parse(sessionStorage.getItem('user'));
//   if (!token && to.path != '/login') {
//     next({ path: '/login' })
//   } else {
//     next()
//   }
// }		
// });
 
new Vue({
  //el: '#app',
  //template: '<App/>',
  router,
	store,
  //components: { App }
  render: h => h(App)
}).$mount('#app')

