<template>
	<section>
		<div class="AskItemList" v-for="(item,index) in this.questionData">
        	<div class="top">
            	<div class="info">
                	<span style="color:#666;">{{item.createTime}}</span><span>来自&nbsp;</span><a href="" class="uname">xiezhengyi1986</a><span>&nbsp;的提问</span>
					<a  class="title" @click="ClickFunQuetion(item)">{{item.title}}</a>
                	<!-- <a href="#" class="title">{{item.title}}</a> -->
                </div>
                <!--<div class="da">
                	<span><em>24</em><dl>已有回答</dl></span>
                </div>-->
            </div>
            <div class="desc">{{item.content}}</div>
        	<div class="tags">
            	<a href="">html</a>
                <div class="Appreciation">
                	<i></i><span>30</span>
                </div>
                <div class="share_bar_con">
                	<span>
                    	<dl>浏览量</dl><em>(16)</em><i>|</i>
                          <dl @click="DZfun">{{msg}}</dl><em class="cur">{{}}</em><i>|</i>
                        <dl>收藏</dl><em class="cur">(8)</em>
                    </span>
                </div>
            </div>
       </div>					
	</section>
</template>

<script>
	export default{
		data(){
			return{
				activeName:'first',
					questionData:'',
					value:'',
					addComment:'',
					Talkshow:false,
					indexs:'',
					talkArray:[],
					msg:'点赞',
					msg1:''
			}
		},
		mounted(){
			this.getQuestionData()
		},
		methods:{
			talkShow(index){
				this.Talkshow = !this.Talkshow
				this.indexs = index
				this.talkArray = []
			},
			getaddComment(index){
				this.talkArray.push(this.value)
				this.value = ''
				this.getaddCommentData()
				
			},
			ClickFunQuetion(data){
				this.$router.push({
					path:'/questionsq',
				})
			},
			getQuestionData(){
				let para = {
					userId:"0",
					offset:'0',
					limit:'10'
				}
				let headerToken = {
					authorization:sessionStorage.getItem('token')
				}
				this.$http.get('/api/question/getLaststQuestions',{
					params:para,
					headers:headerToken
				}).then((res)=>{
					this.questionData = res.data.res
					console.log(this.questionData)
				},error=>{})
			},
			getaddCommentData(){
				let para = {
						content:this.value,
						entityId:'1',
						entityType:'2'
				};
				let headerToken = {
					authorization:window.localStorage.getItem('currentUser_token')
				};
				this.$http.get('/api/comment/addComment',{
					params:para,
					headers:headerToken
				}).then((res)=>{
					this.addComment = res.data.message
					console.log(this.addComment)
				},error=>{})
			}
		}
	}
</script>
<style src="../../../css/style.css">
<style>
</style>