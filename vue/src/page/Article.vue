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

export default{
    name:'article',
    components:{
        ArticleNotice,
        ArticleReply,
    },
    methods:{
        moveNotice(){
             console.log(`move notice`)
            this.$store.dispatch("getNotices")
           
        }
        ,
        moveQna(){
             console.log(`move qna`)
          this.$store.dispatch("getQna")
        }
    },
    mounted(){
        this.$store.dispatch("getNotices")
    }

}
</script>

<style>

</style>

