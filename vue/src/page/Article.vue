<template>
<div>
  <b-card no-body>
    <b-tabs card>
        <b-tab title="공지사항" active @click="moveNotice">     
            <article-notice></article-notice>
        </b-tab>
      
        <b-tab title="Q & A" @click="moveQna">     
            <article-reply ></article-reply>
      </b-tab>
    </b-tabs>
  </b-card>

</div>
</template>


<script>
import ArticleNotice from '@/page/ArticleNotice.vue';
import ArticleReply from '@/page/ArticleReply.vue';
//import http from '@/util/http-common';
export default{
    name:'article',
    components:{
        ArticleNotice,
        ArticleReply,
    },
    methods:{
        moveNotice(){
             console.log(`move notice`)
            // http.get("/board?articleType=NOTICE")
            // .then(response=>{
            //     console.log(`move notice ${response}`, response)
            // }).catch(err=>{
            //     console.log(`move notice error 발생`, err)
            // })

            this.$store.dispatch("getNotices")
           
        }
        ,
        moveQna(){
             console.log(`move qna`)
            //  http.get("/board?articleType=QNA")
            // .then(response=>{
            //     console.log(`move qna ${response}`, response)
            // }).catch(err=>{
            //     console.log(`move qna error 발생`, err)
            // })
          this.$store.dispatch("getQna")
        }
    },
    mounted(){
        this.$store.dispatch("getNotices")
        //this.moveNotice()
    }

}
</script>

<style>

</style>

