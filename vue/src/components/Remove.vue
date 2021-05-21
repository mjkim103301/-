<template>
  <div>삭제중...</div>
</template>
<script>
import axios from "axios";
export default {
  created() {
    // let no = new URL(document.location).searchParams.get("no");
    console.log('remove.............',articleId)
    const articleId = this.$route.query.articleId;
    console.log('remove.............',articleId)
    axios
      .delete(`http://localhost:9999/vue/api/article/${articleId}`)
      .then(({ data }) => {
        if (data == "success") {
          alert("삭제 완료!!!");
          this.$router.push("/list");
        } else {
          alert("삭제중 오류 발생");
          this.$router.push(`'/search?no='+${articleId}`);
        }
      })
      .catch(() => {
        alert("삭제중 오류 발생");
        this.$router.push(`'/search?no='+${articleId}`);
      });
  }
}
</script>
