<template>
  <div>
    <section id="" class="p-1">
      <div class="container">
        <div class="mb-2">
          <button type="button" id="write-notice" class="btn btn-primary" @click="movePage" >글쓰기</button>
          <form class="form-inline float-right">
            <div class="form-group mr-sm-2">
              <select class="form-control" id="selectOption">
                <option selected>내용</option>
                <option>작성일</option>
                <option>글 번호</option>
              </select>
            </div>
            <div class="form-group mr-sm-2">
                <input type="text" class="form-control" id="searchKey">
            </div>
            <button type="submit" class="btn btn-secondary">검색</button>
          </form>
        </div>
        <div class="p-2 mb-5">        
            <table class="table table-hover">
            <thead>
                <tr>
                    <th>글번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody v-if="articles.length>0">
             
                <tr v-for="(article, index) in articles" :key="index">

                    <td>{{article.articleId}}</td>
                    <td class="selectPost"> <router-link :to="`/happyhouse/article/${article.articleId}`" style="color:black;">{{article.subject}}</router-link></td>
                    <td>{{article.userId}}</td>
                    <td>{{article.hit}}</td>
                    <td>{{article.registerTime}}</td>

                </tr>
            </tbody>
            <tbody v-else>
                <tr>
                    <td>1</td>
                    <td class="selectPost"> <router-link :to="`/happyhouse/article/${1}`" style="color:black;">1번 공지</router-link></td>
                    <td>김싸피</td>
                    <td>1</td>
                    <td>2020-05-18</td>

                </tr>
               
               
            </tbody>
            </table>
        </div>  
        <div class="mt-3">
            <ul class="pagination justify-content-center">
                <li class="page-item"><a class="page-link" href="#">최신</a></li>
                <li class="page-item"><a class="page-link" href="#">이전</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item active"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">다음</a></li>
                <li class="page-item"><a class="page-link" href="#">마지막</a></li>
            </ul>
        </div>
    </div>
    </section>
   

  </div>
</template>
<script>
// import http from '@/util/http-common.js'
import moment from "moment";
import { mapGetters} from "vuex";
export default {
  name: "list",
  computed:{
    ...mapGetters(["articles"])
  },
  filters: {
    toDate: function (regtime) {
      return moment(new Date(regtime)).format("YYYY.MM.DD");
    }
  },
  methods: {
    movePage() {
      this.$router.push("/happyhouse/article/write");
    }
  },
  created() {
     this.$store.dispatch("getArticles");
    
  }
};
</script>
