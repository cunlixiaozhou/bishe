<template>
	<div>
		<header>
			<div class="top">
		        <a href="index.html" class="logo"></a>
		        <a href="http://localhost:8080/#/Home" class="nav">首页</a>
		        <a href="index.html" class="nav">全部问题</a>
		        <a href="vist.html" class="nav">待回答</a>
		        <div class="user">
		        	<a class="log" @click="logout">退出登录</a>
		            <a href="http://localhost:8080/#/sign" class="log">注册</a>
		            <a href="http://localhost:8080/#/people_Page" class="log">个人中心</a>
		        </div>
		      <div class="so">
		          <input type="text" name="key" class="key" placeholder="请输入关键词">
		          <input type="submit" class="sobut" value="搜索答案">
		        </div>
		        
		 	 </div>
		</header>
	 <div class="page_main_right">
		<div class="amRight">
    	<a href="http://localhost:8080/#/question" class="askBut">我有问题，我要提问！</a>
        <h2>最新公告</h2>
        <div class="titleList">
        	<a href="">谁帮忙下载个文件呢，有偿，文件需要1个下载积分</a>
            <a href="">多个矩阵相乘程序的编写，我是新手</a>
        </div>
        
        <div class="userInfo">
        	<div class="us">
            	<a href="" class="portrait"><img src=""></a>
                <div class="info">
                	<a href="">xiezhengyi</a>
                    <span><dl>声望：</dl><em>2601</em></span>
                </div>
            </div>
            <div class="wenda">
                <div class="txt"><i class="w">问</i><span>提了 <a href="">767</a> 个问题， <a href="">349</a> 人进行了回答</span></div>
                <div class="txt"><i class="d">答</i><span>回答了 <a href="">0</a> 个问题</span></div>
            </div>
        </div>
        
        <h2>最新回答</h2>
        <div class="newAnswer">
        	<!---item S--->
            <div class="item">
            	
                <div class="info">
                	<a href="" class="uname">黑色幽默y</a> <dl>回答了：</dl><a href="" class="t">c# httpclient调用webapi获取json数</a>
                </div>
            </div>
            <!---item E--->
            <!---item S--->
            <div class="item">
            	
                <div class="info">
                	<a href="" class="uname">黑色幽默y</a> <dl>回答了：</dl><a href="" class="t">c# httpclient调用webapi获取json数</a>
                </div>
            </div>
            <!---item E--->
            <!---item S--->
            <div class="item">
            	
                <div class="info">
                	<a href="" class="uname">黑色幽默y</a> <dl>回答了：</dl><a href="" class="t">c# httpclient调用webapi获取json数</a>
                </div>
            </div>
            <!---item E--->
            <!---item S--->
            <div class="item">
            	
                <div class="info">
                	<a href="" class="uname">黑色幽默y</a> <dl>回答了：</dl><a href="" class="t">c# httpclient调用webapi获取json数</a>
                </div>
            </div>
            <!---item E--->
            <!---item S--->
            <div class="item">
            	
                <div class="info">
                	<a href="" class="uname">黑色幽默y</a> <dl>回答了：</dl><a href="" class="t">c# httpclient调用webapi获取json数</a>
                </div>
            </div>
            <!---item E--->
            <!---item S--->
            <div class="item">
            	
                <div class="info">
                	<a href="" class="uname">黑色幽默y</a> <dl>回答了：</dl><a href="" class="t">c# httpclient调用webapi获取json数</a>
                </div>
            </div>
            <!---item E--->
            <!---item S--->
            <div class="item">
            	
                <div class="info">
                	<a href="" class="uname">黑色幽默y</a> <dl>回答了：</dl><a href="" class="t">c# httpclient调用webapi获取json数</a>
                </div>
            </div>
            <!---item E--->
            <!---item S--->
            <div class="item">
            	
                <div class="info">
                	<a href="" class="uname">黑色幽默y</a> <dl>回答了：</dl><a href="" class="t">c# httpclient调用webapi获取json数</a>
                </div>
            </div>
            <!---item E--->
            <!---item S--->
            <div class="item">
            	
                <div class="info">
                	<a href="" class="uname">黑色幽默y</a> <dl>回答了：</dl><a href="" class="t">c# httpclient调用webapi获取json数</a>
                </div>
            </div>
            <!---item E--->
            <!---item S--->
            <div class="item">
            	
                <div class="info">
                	<a href="" class="uname">黑色幽默y</a> <dl>回答了：</dl><a href="" class="t">c# httpclient调用webapi获取json数</a>
                </div>
            </div>
            <!---item E--->
        </div>
        
       <div style="width:100%; height:20px;"> </div>
       
       
       
	    <div class="floatRight" id="floatLeft2">
	        
	        <div class="footer">
	        	<h2><span>联系我们</span></h2>
	            <div class="qrc">
	            	<span><img src=""><dl>微信客服</dl></span>
	                <span><img src=""><dl>QQ客服</dl></span>
	            </div>
	            <div class="qq">
	            	<span>客服QQ：945149929</span>
	                <span>联系电话：13560463627</span>
	                <span>E-mail：945149929@qq.com</span>
	            </div>
	            <div class="nlink">
	            	<span><a href="">关于我们</a><i>|</i></span>
	                <span><a href="">网站协议</a><i>|</i></span>
	                <span><a href="">联系我们</a></span>
	            </div>
	            <div class="copyright">
	            	<p>&copy; 2018-2019 广东技术师范大学学生周叠，黄志标版权所有</p>
	            </div>
	        </div>   
	    </div>       
    </div>
</div>		
	<div class="page_main_left">
		<transition name="fade" mode="out-in">
			<router-view></router-view>
		</transition>
	</div>
</div>
</template>

<script>
	export default{
		data(){
			return{
				input_value:'',
				select_value:'',
				 activeIndex: '1',
			}
		},
		methods:{
			logout: function () {
				var _this = this;
				this.$confirm('确认退出吗?', '提示', {
					//type: 'warning'
				}).then(() => {
					sessionStorage.removeItem('token');
					_this.$router.push('/login');
				}).catch(() => {

				});
			},
			//我的主页跳转链接
			people_Page(){
				var _this = this;
				_this.$router.push('/people_Page')
			},
			handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
		}
	}
</script>
<style src="../../css/style.css" scoped="scoped"></style>
<style scoped>
	.page_main_left{
	width: 78%;
	height: 100%;
	min-height: 850px;
	/*border: 1px solid red;*/
	background: white;
	box-shadow:0px 2px 5px #303133;
	margin-top: 10px;
	margin-left: 10px;
	box-sizing: border-box;
}
.page_main_right{
	width: 20%;
	height: 100%;
	float: right;
	box-sizing: border-box;
	margin: 10px;
	background: white;
	box-shadow:0px 4px 5px #303133;
}
</style>