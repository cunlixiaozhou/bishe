<template>
	<div>
		<section class="aui-flexView">
	
	<section class="aui-scrollView">
		<div class="aui-tab" data-ydui-tab>
			<div class="tab-panel">
				<div class="tab-panel-item tab-active">
					<a href="javascript:;" class="aui-flex b-line" v-for="(item,index) in attentionData">
						<div class="aui-comm-user">
							<img src="../../../assets/user-001.png" alt="">
						</div>
						<div class="aui-flex-box">
							<h2>{{item.userName}}</h2>
							<h3>{{item.question}}</h3>
							<h3>{{item.attention}}</h3>
							<p>{{item.dianzan}}</p>
						</div>
						<div class="aui-follow">
							<span @click="attenFun(item)"><i>+</i>{{item.flag?'关注':'已关注'}}</span>
							
						</div>
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
	import attentionData from '../../../jsonData/attentionData.json'
	export default{
		data(){
			return{
				message:'关注',
				btnMessage:false,
				flag:false,
				attentionData:[]
			}
		},
		mounted(){
			this.getData()
		},
		methods:{
			getData(){
				this.attentionData = attentionData.RECORDS;
			},
			attenFun(data){	
				alert(data.flag)
				data.flag =false
// 				for(let i=0;i<this.attentionData.length;i++){
// 					if(data.userName===this.attentionData[i].userName){
// 						alert("进来了")
// 						this.message[i] = "已关注"
// 						break;
// 					}
// 				}
				
// 				let para = {
// 					userId:''
// 				}
// 				let headerToken = {
// 					authorization:sessionStorage.getItem('token')
// 				};
// 				this.$http.get('/api/follow/follow',{
// 					params:para,
// 					headers:headerToken
// 				}).then((res)=>{
// 					alert(res.data.message)
// 				},error=>{})
				
			}
		}
	}
</script>
<style src="../../../css/attention.css">
<style scoped="scoped">
	.zm-list-content-medium{
		display: inline-block;
	}
	.zg-right{
		float: right;
		margin: 20px 10px 0 0;
	}
</style>