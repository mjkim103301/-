<template>
  <div>
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">글쓰기</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
            <form id="articleform" method="post" action="">
			<input type="hidden" name="action" id="action" value="registArticle">
                <div class="form-group">
                  <label for="subject">제목:</label>
                  <input type="text" class="form-control" ref="subject" id="subject" name="subject">
                </div>
                <div class="form-group">
                  <label for="content">내용:</label>
                  <textarea rows="8" class="form-control" ref="content" id="content" name="content"></textarea>
                </div>
                <div class="text-center">
                    <button type="button" class="btn btn-primary" @click="createHandler">글작성</button>
                    <button type="button" class="btn btn-secondary" @click="moveHandler">목록</button>
                </div>
            </form>
        </div>
      </div>
    </div>
 
  </div>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      subject: "",
      content: ""
    };
  },
  methods: {
    createHandler() {
      //데이타 검증
      let err = true;
      let msg = "";
      err &&
        !this.subject &&
        ((msg = "제목을 입력해 주세요"), (err = false), this.$refs.subject.focus());
      err &&
        !this.content &&
        ((msg = "내용을 입력해 주세요"), (err = false), this.$refs.content.focus());

      if (!err) {
        alert(msg);
      } else {
        axios
          .post("http://localhost:9000/happyhouse/article/write", {
            subject: this.subject,
            content: this.content
          })
          .then(({ data }) => {
            if (data == "success") {
              alert("등록이 완료 됐습니다.");
              this.moveHandler();
            } else {
              alert("등록 실패");
            }
          })
          .catch(() => {
            alert("error 발생");
          });
      }
    },
    moveHandler() {
      this.$router.push("/happyhouse/article");
    }
  }
}
</script>
