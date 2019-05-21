<template>
<div class="login_bj" >
	<div class="zhuce_body">
		<!--<div class="logo"><a href="#"><img src="images/logo.png" width="114" height="54" border="0"></a></div>-->
	    <div class="zhuce_kong">
	    	<div class="zc">
	        	<div class="bj_bai">
	            <h3>欢迎注册</h3>
	       	  	  <el-form action="" method="">
	                <input  type="text" class="kuang_txt phone" placeholder="用户名" v-model="checkName">
	                <input  type="text" class="kuang_txt email" placeholder="邮箱">
	                <input  type="possword" class="kuang_txt possword" placeholder="密码" v-model="checkPassword">
	                <input  type="possword" class="kuang_txt possword" placeholder="确认密码">
	                <input  type="text" class="kuang_txt yanzm" placeholder="验证码">
	                <div>
	                	<div class="hui_kuang"><img src="images/zc_22.jpg" width="92" height="31"></div>
	                	<div class="shuaxin"><a href="#"><img src="images/zc_25.jpg" width="13" height="14"></a></div>
	                </div>
	                <div>
	               		<input  type="checkbox" value=""><span>已阅读并同意<a href="#" target="_blank"><span class="lan">《XXXXX使用协议》</span></a></span>
	                </div>
	                <input  type="button" class="btn_zhuce" value="注册" @click="sign_Sumbit">
	                
	                </el-form>
	            </div>
	        	<div class="bj_right">
	            	<p>使用以下账号直接登录</p>
	                <a href="#" class="zhuce_qq">QQ注册</a>
	                <a href="#" class="zhuce_wb">微博注册</a>
	                <a href="#" class="zhuce_wx">微信注册</a>
	                <p>已有账号？<a href="http://localhost:8080/#/login">立即登录</a></p>
	            
	            </div>
	        </div>
	        <P>zhoudie.com&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您使用本网站</P>
	    </div>	
	</div>
</div>
</template>

<script>
	export default{
		data(){
			var checkName =(rule,value,callback)=> {
   			if(value===''){
   				callback(new Error("用户名不能为空"))
   			}
   		}
			return{
				checkName:'',
				checkPassword:'',
				 form_check:{
                	checkName:'',
                	checkUserName:'',
                	checkPassword:''
                },
                 rules3: {
                    checkName: [
                        { validator: checkName, trigger: 'blur' }
                        //{ validator: validaePass }
                    ],
                    checkUserName: [
                         { validator: checkName, trigger: 'blur' }
                        //{ validator: validaePass2 }
                    ]
                },
			}
		},
		methods:{
			getzcData(){
//				this.dialogFormVisible = false
				let para = {
					name:this.checkName,
					username:this.checkName,
					password:this.checkPassword
				}
				this.$http.get('/api/user/register',{
					params:para
				}).then((res)=>{
					alert(res.data.message)
					 if(res.data.message ==='注册成功'){
				          	this.$router.push('/login');
				          
				          }
				},error=>{
					consle.log(error)
				})
				
			},
			sign_Sumbit(){
				this.getzcData();
//				this.$refs[formName].validate((valid) => {
//			          if (valid) {
//			            alert('submit!');
//			          } else {
//			            console.log('error submit!!');
//			            return false;
//			          }
//			        });
				
			},
		}
	}
</script>
<style src="../../css/login.css" scoped>
