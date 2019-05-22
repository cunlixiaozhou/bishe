<template>
	<div>
		<div>{{attentionData}}</div>
		<section class="aui-flexView">
			<section class="aui-scrollView">
				<div class="aui-tab" data-ydui-tab>
					<div class="tab-panel">
						<div class="tab-panel-item tab-active">
							<a  class="aui-flex b-line">
								<div class="aui-comm-user">
									<!-- <img src="../../../assets/user-001.png" alt=""> -->
								</div>
								<div class="aui-flex-box"v-for="(item,index) in attentionData">
									<h2>{{item.userName}}</h2>
									<h3>{{item.question}}</h3>
									<h3>{{item.attention}}</h3>
									<p>{{item.dianzan}}</p>
								</div>
								<!-- <div class="aui-follow">
									<span @click="attenFun(item,index)"><i>+</i>{{item.flag?'关注':'已关注'}}</span>
	
								</div> -->
							</a>
						</div>
					</div>
				</div>
				<div style="height:60px;"></div>
	
			</section>
	
		</section>
	
	</div>
</template>

<script>
	export default{
		data(){
			return{
				AttentionData:'',
				message:'',
				attentionData:[]
			}
		},
		created() {
			if(sessionStorage.getItem("attenArr")){
				const this_ = this
				this_.attentionData =this.$store.state.attenArr
				console.log(this_.attentionData)
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
// 				let headerToken = {
// 					authorization:sessionStorage.getItem('token')
// 				}
// 				this.$http.get('/api/follow/getFollowees',{
// 					params:para,
// 					headers:headerToken
// 				}).then((res)=>{
// 					this.AttentionData = res.data.res.users
// 					console.log(this.AttentionData)
// 				},error=>{})
			},
		}
	}
</script>
<style src="../../css/style.css"></style>
<style>
</style>