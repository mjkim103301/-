import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common";
Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        articles: [], //전체 게시글
        article: {}, //update, search할때 현재 보는 게시글
        replies: [], //댓글 목록
    },
    getters: {
        articles(state) {
            console.log("index.js getters articles ", state.articles);
            return state.articles;
        },
        article(state) {
            console.log("index.js getters article ", state.article);
            return state.article;
        },
        replies(state) {
            console.log("[getter] Replies " + state.replies);
            return state.replies;
        },
    },
    mutations: {
        setArticles(state, payload) {
            state.articles = payload;
        },
        setArticle(state, payload) {
            state.article = payload;
        },
        setReplies(state, payload) {
            console.log("[mutaion] reply " + state.replies);
            state.replies = payload;
        },
    },
    actions: {
        getArticles(context) {
            // http
            //   .get("article")
            //   .then(({data}) => {
            //     context.commit("setArticles", data);
            //     console.log('get articles', data);
            //   })
            //   .catch(() => {
            //     alert("수행 중 오류가 발생했습니다.");
            //   });

            http.get("board")
                .then((response) => {
                    console.log("get articles resonse: ", response);
                    context.commit("setArticles", response.data);
                    console.log("get articles response.data: ", response.data);
                })
                .catch(() => {
                    alert("수행 중 오류가 발생했습니다.");
                });
        },
        getArticle(context, payload) {
            http.get(payload)
                .then(({ data }) => {
                    console.log(
                        `index.js getArticle then commit data: ${data}`
                    );
                    context.commit("setArticle", data);
                })
                .catch(() => {
                    alert("오류 발생");
                });
        },

        getReplies(context, payload) {
            console.log("getReplies");
            http.get(payload)
                .then(({ data }) => {
                    console.log(`getReply then commit data: ${data}`);
                    context.commit("setReplies", data);
                })
                .catch(() => {
                    alert("reply 불러오기 오류 발생");
                });
        },
    },
});
