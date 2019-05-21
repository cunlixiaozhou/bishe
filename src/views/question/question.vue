<template>
	<div id="body">
		<div class="ask_main">

	
    
    <div class="amVist">
        
       
        <div class="AnswerQuestions">
        <div id="form1">
        
            <div class="text">
                <input v-model="valueQuestion" type="text" name="textfield" class="input" placeholder="标题：一句话描述清楚问题（最多可输入40个中文字）" required/>
            </div>
                        
            <div class="text">
                <textarea name="content22" id="editor" style="width:99.8%;height:300px;" placeholder="清楚的描述问题细节，让回答员清楚的了解原因（请勿发布违规内容）" v-model="TextQuestion"></textarea>
            </div>
            <div class="text">
            <h2>添加标签(<span>最多添加5个标签</span>)</h2>
            <input id="tags" type="text" class="tags" value="PHP,JS"  placeholder="输入后按回车添加标签">
            </div>
            
            <div class="tijiao">
            	<el-button type="primary" @click="getaddQuestion">提交问题</el-button>
            </div>
            <div class="text">
            	<h3><span>提交表示您已经同意本站</span><a href="">协议</a></h3>
            </div>
        
        </div>
        </div>
    	<!--发布提问 E--->
    
    	
    </div>
    
    

</div>
	</div>
</template>

<script>
	import bus from '../../js/bus'
	export  default{
		data(){
			return{
				valueQuestion:'',
				valueTalk:'',
				TextQuestion:''
				
			}
		},
		methods:{
			cancel(){
				this.valueQuestion = '';
				this.valueTalk = ''
			},
			getaddQuestion(){
				
				let para ={
					title:this.valueQuestion,
					content:this.TextQuestion
				};
				let headerToken = {
					authorization:sessionStorage.getItem('token')
				};
				this.$http.get('/api/question/addQuestion',{
					params:para,
					headers:headerToken
				}).then((res)=>{
					alert(res.data.message)
					if(res.data.message ==='添加成功'){
						this.valueQuestion = '';
						this.TextQuestion = '';
					}
				},error=>{})
				 
			}
		}
	}
</script>
<style src="../../css/style.css" scoped="scoped"></style>
<style scoped="scoped">
	
	#body{
		position: relative;
		top: 240px;
		/*transform: translateY(-50%);*/
		width: 100%;
		height: 100%;
		display: flex;
		justify-content: space-around;
		
	}
	.box1{
		width: 650px;
		height: 400px;
		border: 1px solid blue;
	}
	.box1_header{
		height: 40px;
		width: 100%;
		background: springgreen;
		line-height: 40px;
	}
</style>