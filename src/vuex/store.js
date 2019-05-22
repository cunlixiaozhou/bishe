import Vue from 'vue'
import Vuex from 'vuex'
//import * as actions from './actions'
//import * as getters from './getters'
//import user from '../store/user';

Vue.use(Vuex)

// 创建 store 实例
export default new Vuex.Store({
//  modules:{
//		users:user
//	},
	state:{  
		token:'',
		attenArr:JSON.parse(sessionStorage.getItem("attenArr")) ||[],
		},
		
	mutations:{  
	set_token(state, token) {  
	state.token = token  
	sessionStorage.token = token
	},  
	del_token(state) {  
		state.token = ''
		sessionStorage.removeItem('token')
	},
	 getAttenData(state,arr){
		 sessionStorage.setItem('attenArr',arr);
		 state.attenArr = arr
	 }
	}   
	})