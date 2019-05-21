<template>
	<div>
	<div class="ask_main">
    <div class="amVist">
    
	        <!--<div class="curNav">
	            <a href="">网站首页</a><span>></span>
	        </div>-->
        
        <!-----详情信息 S-------->
        <div class="vistInfo">
        	<h1><span>[已采纳]&nbsp;</span>电子烟有害吗？电子烟有什么危害？电子烟有害吗？电子烟有什么危害？电子烟有害吗？电子烟有什么危害？</h1>
            
        	<div class="fui">
                <div class="time">2小时前 <span>提问</span></div>
                <div class="Appreciation"><i></i><span>10</span></div>
            </div>
            
            <div class="content">
            唉，又看到了这个关于“敢不敢”的话题了，记得前不久，因为北京同仁堂蜂蜜造假事件，我回答过“你还敢相信那些所谓的大品牌吗”这个问题。

什么时候开始，作为一个消费者，在买东西、住酒店之前，不是先问问自己的钱包：你能不能支付呀？而是问自己：你敢不敢消费呀？以前是没钱不能花，现在是有钱不敢花，真是可笑又可悲!

酒店为什么使用白床单而不是其他颜色较深的，如黑色和棕色的床单呢？这样即使被单、床单脏了，我们消费者仅凭肉眼不是很难察觉吗？其实酒店最初使用白色床单就是为了让顾客满意，白色的被单除了给人留下一种如同白云般舒适柔软的感觉之外，还传达给顾客一个重要的信息，干净、清洁，让顾客更加信任该酒店。

            </div>
            
            <div class="vice-info">
            	<a class="MydaBut" id="MydaBut" @click="responsedQuestion"><i>答</i><span>我来答</span></a>
                <div class="th">
                	<a href="" class="z"><span>点赞</span><em>2</em></a><i>|</i>
                    <a href="" class="z"><span>收藏</span><em>1</em></a><i>|</i>
                    <a href="" class="z"><span>举报</span></a>
                </div>
                <div class="hits">浏览 16094 次</div>
            </div>
            
            <div class="AnswerForm" id="AnswerForm" v-if="this.showForm===true">
            <p>&hearts; 请认真作答，如牛头不对马嘴或发布违规及广告内容，发现一律封号处理！</p>
           <!-- <el-form id="form1" name="form1" method="" action="">-->
            <textarea name="content22" id="editor1" style="width:99.8%;height:200px;" v-model="value"></textarea>
            <div class="button">
            	<a class="sq" id="sq">​&spades; 收起</a>
            	<button  class="button" @click="getaddCommentData">提交回答</button>
            </div>
            <!--</el-form>-->
            </div>
            
            <div class="AnswerQuantity">
            <span>已有<em>{{this.textMessage.length}}</em>个回答</span>
            </div>


            <div class="AnswerItemList" v-for="(item,index) in textMessage">
            	<div class="userInfo">
                	<a href="" class="portrait"><img src=""></a>
                    <div class="info">
                        <span><a href="">xiezhengyi</a></span>
                        <span><dl>回答时间：</dl><em>2019年01月02日 16:27</em></span>
                    </div>
                </div>
                <div class="content" id="wrap1">
            	{{item.content}}---{{index}}				
                <div class="gradient" id="gradient1"></div>
            	</div>
                <div class="read-more" id="read-more1"></div>
                <div class="fuInfo">
                	<div class="Fabulous"><span>点赞</span><em>46</em></div>
                    <a class="Report" @click="deleteText(index)">删除</a>
                </div>
            </div>        
            <div class="pageType">
            <ul class="pagination">
            	<li class="disabled"><dl>上一页</dl></li>
                <li class="active"><span>1</span></li>
                <li><a href="">2</a></li>
                <li><a href="">3</a></li>
                <li><a href="">下一页</a></li>
                <li class='pageRemark'>共<b>3</b>页 <b>43</b>条数据</li>
            </ul>
            </div>    
        </div>
    </div>
   		

</div>

	</div>
	
</template>

<script>
	import store from '../../vuex/store'
	export default{
		name:'questionsquares',
		data(){
			return{
				questionData:'',
				showForm:false,
				value:'',
				textMessage:[]
			}
		},
		mounted(){
			this.getQuestionData();
			this.findCommentData();
		},
		methods:{
			findCommentData(){
				let para = {
						entityId:'1',
						entityType:'1'
				};
				let headerToken = {
					authorization:sessionStorage.getItem('token')
				};
				this.$http.get('/api/comment/queryComment',{
					params:para,
					headers:headerToken
				}).then((res)=>{
					this.textMessage = res.data.res
					console.log(this.addComment)
					this.value = ""
					this.showForm = !this.showForm
				},error=>{})
			},
			responsedQuestion(){
				this.showForm = !this.showForm
			},
			deleteText(index){	
				alert(index)
				let para = {
						id:'403'
				};
				let headerToken = {
					authorization:sessionStorage.getItem('token')
				};
				this.$http.get('/api/comment/deleteComment',{
					params:para,
					headers:headerToken
				}).then((res)=>{
					this.deleteComment = res.data.message
					if(this.deleteComment ==='删除成功'){
						alert(this.deleteComment)
						this.getaddCommentData()
					}else{
						alert(this.deleteComment)
					}
					
				},error=>{})
			},
			getaddCommentData(){
				let para = {
						content:this.value,
						entityId:'1',
						entityType:'1'
				};
				let headerToken = {
					authorization:sessionStorage.getItem('token')
				};
				this.$http.get('/api/comment/addComment',{
					params:para,
					headers:headerToken
				}).then((res)=>{
					this.addComment = res.data.message
					console.log(this.addComment)
					this.findCommentData();
					this.value = ""
					this.showForm = !this.showForm
				},error=>{})
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
					headers:authorization
				}).then((res)=>{
					this.questionData = res.data.res
					console.log(this.questionData)
				},error=>{})
			}
		}
	}
</script>

<style src="../../css/style.css">