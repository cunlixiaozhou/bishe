import Vue from 'vue'
import routes from '../routes';
export default {

 state:{

  currentUser:{

   getUserName(){

    return sessionStorage.getItem("currentUser_name");

   },

   getUserToken(){

    return sessionStorage.getItem("currentUser_token");

   }

  }

 },

// mutations:{
//
//setUser(state,{user_name,user_token}){
//
// // 在这里把用户名和token保存起来
//
// sessionStorage.setItem("currentUser_name",user_name);
//
// sessionStorage.setItem("currentUser_token",user_token);
//
//}
//
// },
mutations:{  
set_token(state, token) {  
state.token = token  
sessionStorage.setItem("currentUser_token",state.token);
},  
del_token(state) {  
state.token = ''  
sessionStorage.removeItem('token')  
}  
}, 

 actions:{

//userLogin(context,{user_name,user_pass}){
//
// // 发送get请求做权限认证(真实开发建议用post的方式)
//
// let url = "/api/user/login?username="+user_name+"&password="+user_pass
// Vue.http.post(url)
//  .then((res)=>{	
//  	
//   if (res.data.errcode===0){
//    var token = res.data.res;
//		
//    if (token != ""){
//
//     // 后端API验证通过
//
//     // 调用上面mutations里定义的方法
//
//     context.commit("setUser",{"user_name":user_name,"user_token":token});
//
//    }
//
//   }else{
//
//    alert("用户名密码错误");
//    
//   }
//
//  },(res)=>{
//
//   alert("请求失败进入这里")
//
//  });
//	
//}

 }

}
