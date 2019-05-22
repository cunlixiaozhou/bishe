<template>
	<div class="amIn">
    	
    	<div class="AskItemList" v-for="item in PopularData">
        	<div class="top">
            	<div class="info">
                	<span style="color:#666;">2小时前&nbsp;</span><span>来自&nbsp;</span><a href="" class="uname">xiezhengyi1986</a><span>&nbsp;的提问</span>
                	<a href="http://localhost:8080/#/questionsq" class="title">{{item.textheader}}</a>
                </div>
                <div class="da">
                	<span><em>24</em><dl>已有回答</dl></span>
                </div>
            </div>
            <div class="desc">{{item.textbody}}</div>
        	<div class="tags">
            	<a href="">html</a>
                <div class="Appreciation">
                	<i></i><span>25</span>
                </div>
                <div class="share_bar_con">
                	<span>
                    	<dl><em>{{item.attention}}</em><i>|</i></dl>
                        <dl @click="DZfun(item)"><em class="cur">{{item.flag?"点赞":"已点赞"}}</em><i>|</i></dl>
                        <dl>收藏</dl><em class="cur">(8)</em>
                    </span>
                </div>
            </div>
        </div>

       
    </div>

</template>

<script>
	import PopularData from '../../../jsonData/PopularData.json'
	export default{
		data(){
			return{
				activeName:'first',
					questionData:'',
					value:'',
					addComment:'',
					Talkshow:false,
					indexs:'',
					indexDZ:'16',
					talkArray:[],
					flag:false,
					msg:'点赞',
					PopularData:[]
					
			}
		},
		mounted(){
			this.getQuestionData();
			this.getPopularData()
		},
		methods:{
			getPopularData(){
				this.PopularData = PopularData.RECORDS
			},
			DZfun(data){
				data.flag =!data.flag
				if(this.flag){
					this.msg="已点赞"
					this.indexDZ = Number(this.indexDZ)+1;
					this.msg="点赞"
				}else{
					this.msg="点赞"
					this.indexDZ = Number(this.indexDZ)-1
				}
			},
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
						entityType:'1'
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