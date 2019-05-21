<template>
	<div class="login_bj" >
<div class="zhuce_body">
	<!--<div class="logo"><a href="#"><img src="images/logo.png" width="114" height="54" border="0"></a></div>-->
    <div class="zhuce_kong login_kuang">
    	<div class="zc">
        	<div class="bj_bai">
            <h3>登录</h3>
       	  	  <form action="" method="">
                <input name="" type="text" class="kuang_txt" placeholder="用户名" v-model="username">
                <input name="" type="password" class="kuang_txt" placeholder="密码" v-model="password">
                <div>
               		<a href="#">忘记密码？</a><input name="" type="checkbox" value="" checked><span>记住我</span> 
                </div>
                <input name="登录" type="button" class="btn_zhuce" value="登录" @click="login">
                
                </form>
            </div>
        	<div class="bj_right">
            	<p>使用以下账号直接登录</p>
                <a href="http://localhost:8080/#/sign" class="zhuce_qq">QQ注册</a>
                <a href="#" class="zhuce_wb">微博注册</a>
                <a href="#" class="zhuce_wx">微信注册</a>
               <a href="http://localhost:8080/#/sign" class="log">注册</a>
            
            </div>
        </div>
        <P>zhoudie.com&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您使用本网站，感谢您对我们的信任，祝您使用愉快</P>
    </div>

</div>
    
</div>
	
</template>

<script>
	 import axios from 'axios';
//	 import {actions} from '../../store/user'
  	axios.defaults.withCredentials = true
	import { requestLogin } from '../../api/api';
	import store from '../../vuex/store'
  export default {
   data() {
            return {
            	password:'',
			    username:'',
            	message:'',
                logining: false,
		        tokend:'',
			    formLabelWidth: '120px', 
                userToken:'',
                checked:true
            }
        },
     methods: {
			login() {
					let _this = this;
			        var params = new URLSearchParams();
			        params.append('username', this.username);
			        params.append('password', this.password);
			        axios.post('/api/user/login',params).then(res => {
			            console.log(res.data);
				          let data =res.data;
				          // 将用户token保存到vuex中
				          _this.$store.commit('set_token', data['res']); 
				          if(store.state.token){
				          	_this.$router.push('/Home');
				          alert('登陆成功');
				          
				          }
				          
				        }).catch(error => {
				          alert('账号或密码错误');
				          console.log(error);
				        });
			}
        }
  }
</script>
<style src="../../css/login.css" scoped>
<style scoped>
	.login{
		width: 400px;
		height: 300px;
		border: 1px solid  red;
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%,-50%);
		display: flex;
		justify-content: center;
	}
	.demo-ruleForm{
		border: 1px solid blue;
		width: 100%;
		padding-top: 10px;
		padding-right: 50px;
	}
</style>