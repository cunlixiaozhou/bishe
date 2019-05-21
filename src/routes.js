import login from './views/login/login.vue';
import HomePage from './views/HomePage/homePage.vue';
import question from './views/question/question.vue';
import home from './views/Home/Home.vue';
import questionsq from './views/Home/questionsq.vue';
import information from './views/information/information.vue';
import sign from './views/login/sign.vue'



let routes = [
		{
		path:'/login',
        component: login,
        name: '登录',
		},
		{
		path:'/sign',
        component: ()=>import('./views/login/sign.vue'),
        name: '注册',
		},
		  {
		  path:'/BigScreen',
		      component: ()=>import('./views/daping/hczz_Finish.vue'),
		      name: '注册',
		  },
		{
		path:'/HomePage',
        component: HomePage,
        name: '首页',
//       meta:{
//      	requireAuth:true
//      }
		},
		{
		path:'/HomePage',
        component: HomePage,
        name: '提问区',
//       meta:{
//      	requireAuth:true
//      },
        children:[
        	{
        		path:'/question',
		        component: question,
		        name: '首页',
//		         meta:{
//      	requireAuth:true
//      }
		   },
		    {
        		path:'/questionsq',
		        component: questionsq,
		        name: '',
//		         meta:{
//      	requireAuth:true
//      }
		   },
        ]
		},
		{
		path:'/HomePage',
        component: HomePage,
        name: '问题区',
//       meta:{
//      	requireAuth:true
//      },
        children:[
        	{
        		path:'/questionShow',
		        component: ()=>import('./views/question/questionShow.vue'),
		        name: '首页',
//		         meta:{
//      	requireAuth:true
//      }
		    }
        ]
		},
		{
		path:'/',
        component: HomePage,
        name: '提问区',
//       meta:{
//      	requireAuth:true
//      },
        children:[
        	{
        		path:'/home',
		        component: home,
		        name: '首页',
//		         meta:{
//      	requireAuth:true
//      }
		    }
        ]
		},
		{
		path:'/',
        component: HomePage,
        name: '提问区',
//       meta:{
//      	requireAuth:true
//      },
        children:[
        	{
        		path:'/information',
		        component: information,
		        name: '首页',
//		         meta:{
//      	requireAuth:true
//      }
		    }
        ]
		},
		
        	{
        		path:'/people_Page',
		        component:  ()=>import('./views/peoplePage/people_Page.vue'),
		        name: '我的主页',
		        redirect: '/OwnQuestioned',
				children:[
					{
						path:'/OwnQuestioned',
						component:()=>import('./views/peoplePage/OwnQuestioned.vue'),
						name:'已提问'
					},
					{
						path:'/OwnAnswer',
						component:()=>import('./views/peoplePage/OwnAnswer.vue'),
						name:'已回答'
					},
					{
						path:'/OwnAttention',
						component:()=>import('./views/peoplePage/OwnAttention.vue'),
						name:'已回答'
					},
					{
						path:'/Fans',
						component:()=>import('./views/peoplePage/Fans.vue'),
						name:'粉丝'
					},
					{
						path:'/OwnCollect',
						component:()=>import('./views/peoplePage/OwnCollect.vue'),
						name:'收藏'
					}
				]
		    }
 
]
export default routes





