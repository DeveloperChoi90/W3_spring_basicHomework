let targetId;
let cnt;

$(document).ready(function () {
    // id 가 query 인 녀석 위에서 엔터를 누르면 execSearch() 함수를 실행하라는 뜻입니다.
    $('#query').on('keypress', function (e) {
        if (e.key === 'Enter') {
            execSearch();
        }
    });
    $('#close').on('click', function () {
        $('#container').removeClass('active');
    })


    $('.notice div.notice-register').on('click', function () {
        $('div.notice-see').removeClass('active');
        $('div.notice-register').addClass('active');

        $('#see-area').hide();
        $('#register-area').show();
    })

    $('#see-area').show();
    $('#register-area').hide();

    showPosts();
})


function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

//////////////////////////////////////////////////////////////////////////////////////////
///// 여기 아래에서부터 코드를 작성합니다. ////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

function getPosts() {
    /**
     * 검색어 input id: query
     * 검색결과 목록: #search-result-box
     * 검색결과 HTML 만드는 함수: addHTML
     */
    // 1. 검색창의 입력값을 가져온다.
    // 2. 검색창 입력값을 검사하고, 입력하지 않았을 경우 focus.
    $(`#add-posts`).empty();
    $.ajax({
        type: 'GET',
        url: `/api/posts`,
        success: function (response){
            for (let i = 0; i < response.length; i++) {
                let posts = response[i];
                let id = posts["id"];
                let title = posts["title"];
                let username = posts["userName"];
                // let content = posts["content"];
                let datetime = posts["createdAt"]
                let tmpHtml = addHTML(id, title, username, datetime);
                $(`#add-posts`).append(tmpHtml)
            }
        }
    })
    // 4. for 문마다 itemDto를 꺼내서 HTML 만들고 검색결과 목록에 붙이기!
}

function addHTML(id, title, username, datetime) {
    return `<tbody class="tbody">
                <tr>
                    <td>${id}</td>
                    <td>${username}</td>
                    <td><a href="">${title}</a></td>
                    <td>${datetime}</td>
                </tr>
            </tbody>`
}

function addPosts(itemDto) {
    /**
     * modal 뜨게 하는 법: $('#container').addClass('active');
     * data를 ajax로 전달할 때는 두 가지가 매우 중요
     * 1. contentType: "application/json",
     * 2. data: JSON.stringify(itemDto),
     */
    // console.log(itemDto); // JSON.stringify로 넘어온 itemDto 변환되 넘어와도 JSON형식으로 넘어 온다
    // console.log(JSON.stringify(itemDto));
    // 1. POST /api/products 에 관심 상품 생성 요청
    $.ajax({
        type: "POST",
        url: "/api/products",
        data: JSON.stringify(itemDto),
        contentType: "application/json",
        success: function (response){
            $('#container').addClass('active');
            targetId = response.id;
        }
    })
    // 2. 응답 함수에서 modal을 뜨게 하고, targetId 를 reponse.id 로 설정 (숙제로 myprice 설정하기 위함)

}

function deletePosts() {
    /**
     * 관심상품 목록: #product-container
     * 검색결과 목록: #search-result-box
     * 관심상품 HTML 만드는 함수: addProductItem
     */
    let password = $(`#password`).val();
    let data = {"password": password};
    // 1. GET /api/products 요청
    $.ajax({
        type: "DELETE",
        url: "/api/posts/${id}",
        data: JSON.stringify(data),
        success: function (response) {
            // 2. 관심상품 목록, 검색결과 목록 비우기
            $(`#post-container`).empty();
            // 3. for 문마다 관심 상품 HTML 만들어서 관심상품 목록에 붙이기!

        }
    })
}

function update() {

    return `<div class="product-card" onclick="window.location.href='${product.link}'">
                <div class="card-header">
                    <img src="${product.image}"
                         alt="">
                </div>
                <div class="card-body">
                    <div class="title">
                        ${product.title}
                    </div>
                    <div class="lprice">
                        <span>${numberWithCommas(product.lprice)}</span>원
                    </div>
                    <div class="isgood ${product.lprice <= product.myprice ? '' : 'none'}">
                        최저가
                    </div>
                </div>
            </div>`;
}

function setMyprice() {
    /**
     * 숙제! myprice 값 설정하기.
     * 1. id가 myprice 인 input 태그에서 값을 가져온다.
     * 2. 만약 값을 입력하지 않았으면 alert를 띄우고 중단한다.
     * 3. PUT /api/product/${targetId} 에 data를 전달한다.
     *    주의) contentType: "application/json",
     *         data: JSON.stringify({myprice: myprice}),
     *         빠뜨리지 말 것!
     * 4. 모달을 종료한다. $('#container').removeClass('active');
     * 5, 성공적으로 등록되었음을 알리는 alert를 띄운다.
     * 6. 창을 새로고침한다. window.location.reload();
     */
    let myprice = $(`#myprice`).val();
    if(myprice === '') {
        alert("올바른 가격이 입력되지 않았습니다.");
        return;
    }

    $.ajax({
        type: "PUT",
        url: `/api/products/${targetId}`,
        contentType: "application/json",
        data: JSON.stringify({myprice : myprice}),
        success: function (response) {
            $(`#container`).removeClass('active');
            alert("성공적으로 등록되었습니다.");
            window.location.reload();
        }
    })
}