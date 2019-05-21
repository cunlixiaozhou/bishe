<template>
	<setcion class="pageBG">
		<div class="page_main">
			<div class="">
				  <el-tabs v-model="activeName" @tab-click="handleClick">
				    <el-tab-pane label="推荐动态" name="first">
				    	<dynamic></dynamic>
				    </el-tab-pane>
				    <el-tab-pane label="问题广场" name="second">
				    	<quares></quares>
				    </el-tab-pane>
				    <el-tab-pane label="关注" name="third">
				    	<attention></attention>
				    </el-tab-pane>			   
				  </el-tabs>
			 </div>
		</div>
		
	</setcion>
	
</template>

<script>
	import quares from './question_quares/Question_quares'
	import dynamic from './Popular_dynamic/Popular_dynamic.vue'
	import attention from './attention/attention.vue'
	export default{
		components:{
			'quares':quares,
			'dynamic':dynamic,
			'attention':attention
		},
		data(){
			return{
				activeName:'first',
					questionData:''
			}
		}
//		mounted(){
//			this.getQuestionData()
//		},
//		methods:{
//			getQuestionData(){
//				let para = {
//					userId:"1",
//					offset:'0',
//					limit:'10'
//				}
//				let headerToken = {
//					authorization:window.localStorage.getItem('currentUser_token')
//				}
//				this.$http.get('/api/question/getLaststQuestions',{
//					params:para,
//					headers:headerToken
//				}).then((res)=>{
//					this.questionData = res.data.res
//					console.log(this.questionData)
//				},error=>{})
//			}
//		}
	}
</script>

<style src="../../css/bace.css">
</style>