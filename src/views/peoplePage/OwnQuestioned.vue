<template>
	<div>
		<div class="AskItemList" v-for="item in questionData">
        	<div class="top">
            	<div class="info">
                	<span style="color:#666;">2小时前&nbsp;</span><span>来自&nbsp;</span><a href="" class="uname">xiezhengyi1986</a><span>&nbsp;的提问</span>
                	<h2 class="title">{{item.title}}</h2>
               </div>
            </div>
            <div class="desc">
            	<img src="images/1.jpg" class="cover">
                <div class="c">
                	{{item.content}}
                </div>
        	</div>
            <div class="tags">
            	<a href="">html</a>
                <div class="share_bar_con">
                	<span>
                    	<dl>浏览量</dl><em>(16)</em><i>|</i>
                        <dl>点赞</dl><em class="cur">(16)</em><i>|</i>
                        <dl>收藏</dl><em class="cur">(8)</em>
                    </span>
                </div>
            </div>
        </div>
	</div>
</template>

<script>
	export default{
		data(){
			return{
				questionData:''
			}
		},
		watch:{
		  $route(to,from){
		    alert(to.path);
		  }
		},
		mounted(){
			this.getQuestionData()	
		},
		methods:{
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
		}
	}
</script>
<style src="../../css/style.css">
<style>
</style>