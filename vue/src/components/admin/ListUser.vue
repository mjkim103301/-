<template>
    <div>
        <section id="" class="p-1">
            <div class="container">
                <div>
                    <form class="form-inline float-right">
                        <div class="form-group mr-sm-2">
                            <select class="form-control" id="selectOption">
                                <option selected value="user_id">ID</option>
                                <option value="user_name">이름</option>
                            </select>
                        </div>
                        <div class="form-group mr-sm-2">
                            <input
                                type="text"
                                class="form-control"
                                id="searchWord"
                                @keydown.enter="searchUserHandler()"
                            />
                        </div>
                        <button
                            type="button"
                            class="btn btn-secondary"
                            @click="searchUserHandler()"
                        >
                            검색
                        </button>
                    </form>
                </div>

                <div class="p-2 mb-5">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>이름</th>
                                <th>email</th>
                                <th>주소</th>
                                <th>가입일</th>
                            </tr>
                        </thead>
                        <tbody v-if="users.length > 0">
                            <tr v-for="(user, index) in users" :key="index">
                                <td>{{ user.userId }}</td>
                                <td>{{ user.userName }}</td>
                                <td>{{ user.email }}</td>
                                <td>{{ user.address }}</td>
                                <td>{{ user.registerTime }}</td>
                                <button
                                    class="btn ptn-primary"
                                    @click="removeUserHandler(user)"
                                >
                                    삭제
                                </button>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="mt-3">
                    <ul class="pagination justify-content-center">
                        <li class="page-item">
                            <a class="page-link" @click="movePageHandler(1)"
                                >최신</a
                            >
                        </li>
                        <li class="page-item">
                            <a
                                class="page-link"
                                @click="movePageHandler(page - 5)"
                                >이전</a
                            >
                        </li>
                        <li
                            v-for="nav in navigationItem"
                            :key="nav"
                            class="page-item"
                        >
                            <a
                                v-if="nav == page"
                                class="page-link bg-primary text-light"
                                @click="movePageHandler(nav)"
                                >{{ nav }}</a
                            >
                            <a
                                v-else
                                class="page-link"
                                @click="movePageHandler(nav)"
                                >{{ nav }}</a
                            >
                        </li>

                        <li class="page-item">
                            <a
                                class="page-link"
                                @click="movePageHandler(page + 5)"
                                >다음</a
                            >
                        </li>
                        <li class="page-item">
                            <a
                                class="page-link"
                                @click="movePageHandler(lastPage)"
                                >마지막</a
                            >
                        </li>
                    </ul>
                </div>
            </div>
        </section>
    </div>
</template>
<script>
import moment from "moment";

import http from "@/util/http-common.js";

export default {
    name: "ListUser",

    data() {
        return {
            users: [],
            page: 1,
            lastPage: 1,
            navigationItem: [],
            key: "",
            word: "",
        };
    },
    filters: {
        toDate: function (regtime) {
            return moment(new Date(regtime)).format("YY.M.D H시 mm분");
        },
    },
    methods: {
        searchUserHandler() {
            this.key = document.getElementById("selectOption").value;
            this.word = document.getElementById("searchWord").value;
            console.log("search userHandler : " + this.key + this.word);
            this.listUser();
        },

        removeUserHandler(user) {
            http.delete(`admin/user/remove/${user.userId}`)
                .then(({ status }) => {
                    if (status != 200) {
                        alert("에러 ! ");
                        return;
                    }
                    this.listUser();
                })
                .catch(() => {
                    alert("에러 ! ");
                });
        },
        movePageHandler(page) {
            this.page =
                page > this.lastPage ? this.lastPage : page < 1 ? 1 : page;
            console.log(page + " " + this.lastPage);
            console.log(this.page);
            this.listUser();
        },

        createNavigation() {
            this.navigationItem = [];
            http.get(`admin/user/list/navigation`)
                .then((response) => {
                    console.log(response);
                    if (response.status != 200) {
                        alert("오류 발생");
                        return;
                    }
                    this.lastPage = response.data.totalPageCount;
                    console.log("start : " + response.data.startPageNumber);
                    console.log("end : " + response.data.endPageNumber);
                    for (
                        let i = response.data.startPageNumber;
                        i <= response.data.endPageNumber;
                        i++
                    ) {
                        this.navigationItem.push(i);
                    }
                })
                .catch(() => {
                    alert("오류 발생 ㅠ");
                });
        },

        listUser() {
            let params = {
                page: this.page,
                key: this.key,
                word: this.word,
            };
            http.get(`admin/user/list`, { params })
                .then((response) => {
                    console.log(response.status);
                    if (response.status != 200) {
                        alert("오류 발생");
                        return;
                    }
                    this.content = "";
                    this.users = response.data;
                    this.createNavigation();
                })
                .catch(() => {
                    alert("오류 발생 ㅠ");
                });
        },
    },
    created() {
        console.log("UserList created" + `${this.$route.params.articleId}`);
        this.$store.dispatch("getSession");
        this.listUser();
    },
};
</script>
