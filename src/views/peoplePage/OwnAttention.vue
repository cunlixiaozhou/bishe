<template>
	<div>
		<div class="AskItemList" v-for="item in AttentionData">
        	<!--<div class="top">
            	<div class="info">
                	<span style="color:#666;">2小时前&nbsp;</span><span>来自&nbsp;</span><a href="" class="uname">xiezhengyi1986</a><span>&nbsp;的提问</span>
                	<h2 class="title">{{item.title}}</h2>
               </div>
            </div>-->
            <div class="desc">
            	<img :src="item.headUrl" class="cover">
                <div class="c">
                	{{item.name}}
                </div>
        	</div>
            <div class="tags">
            	<a href="">html</a>
                <div class="share_bar_con">
                	<el-button @click="attenFun(index)" type="primary" class="zg-btn zg-btn-follow zm-rich-follow-btn small nth-0">{{message}}</el-button>
                </div>
            </div>
        </div>
	</div>
</template>

<script>
	export default{
		data(){
			return{
				AttentionData:'',
				message:''
			}
		},
		mounted(){
			this.getAttentionData()
		},
		methods:{
			getAttentionData(){
				let para = {
					userId:"1",
					offset:'0',
					limit:'10'
				}
				let headerToken = {
					authorization:sessionStorage.getItem('token')
				}
				this.$http.get('/api/follow/getFollowees',{
					params:para,
					headers:headerToken
				}).then((res)=>{
					this.AttentionData = res.data.res.users
					console.log(this.AttentionData)
				},error=>{})
			},
		}
	}
</script>
<style src="../../css/style.css">
<style>
</style>