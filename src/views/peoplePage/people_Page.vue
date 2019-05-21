<template>
	<div class="people_body">
		<div class="people_title">
			<div class="people_title_photo">
				<div class="photo">
					<img src="../../assets/2.jpg"/>
					<h4>用户名：zd帅的一批</h4>
					<div><a href="http://localhost:8080/#/Home">返回首页</a></div>
				</div>
			</div>
			<div class="people_title_nav">
				<ul>
					<li><a href="http://localhost:8080/#/OwnQuestioned">323<br/>提问</a></li>
					<li><a href="http://localhost:8080/#/OwnAnswer">323<br/>回答</a></li>
					<li><a href="http://localhost:8080/#/OwnAttention">323<br/>已关注</a></li>
					<li><a href="http://localhost:8080/#/Fans">323<br/>粉丝</a></li>
					<li><a href="http://localhost:8080/#/OwnCollect">323<br/>收藏</a></li>
				</ul>
			</div>
		</div>
		<div class="">			
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
				
			}
		},
		watch:{
		  $route(to,from){
		  
		  }
		},
	}
</script>

<style src="../../css/bace.css" scoped="scoped">
</style>
<style type="text/css" scoped="scoped">
	.photo{
		width:200px;
		text-align: center;
	}
	.photo h4{
		margin: 0;
	}
	.photo img{
		margin-top:15px;
		width: 80px;
		height: 80px;
	}
</style>