const productName = document.getElementById("productName").textContent;
const productPrice = document.getElementById("productPrice").textContent;
const buyerEmail = document.getElementById("buyerEmail").value;
const buyerName = document.getElementById("buyerName").value;
const buyerTel = document.getElementById("buyerTel").value;
const buyerAddr = document.getElementById("buyerAddr").value;
const buyerPostcode = document.getElementById("buyerPostcode").value;
const buyerProductId = document.getElementById("buyerProductId").value;
const buyerUserId = document.getElementById("buyerUserId").value;

const IMP = window.IMP;
IMP.init("imp66770306");

function generateMerchantUid() {
    const now = new Date();
    const year = now.getFullYear().toString().substr(2, 2);
    const month = (now.getMonth() + 1).toString().padStart(2, '0');
    const day = now.getDate().toString().padStart(2, '0');
    const timestamp = year + month + day;
    return "ORD" + timestamp + "-" + buyerProductId.toString().padStart(4, '0') + buyerUserId.toString().padStart(4, '0');
}

function requestPay() {
    const quantity = parseInt(document.getElementById("quantity").value);
    const amount = parseInt(productPrice) * quantity;
    const merchant_uid = generateMerchantUid();
    IMP.request_pay({
        pg: "kakaopay",
        tid: "8559342fd00616b5ff4b2faaea74ca65",
        pay_method: "card",
        merchant_uid: merchant_uid,
        name: productName,
        amount: amount,
        buyer_email: buyerEmail,
        buyer_name: buyerName,
        buyer_tel: buyerTel,
        buyer_addr: buyerAddr,
        buyer_postcode: buyerPostcode
    }, function (rsp) {
        $.ajax({
            type: 'POST',
            url: '/verify/' + rsp.imp_uid
        }).done(function(data) {
            if(rsp.paid_amount === data.response.amount){
                alert("결제 성공");
                createOrder(quantity, amount)
            } else {
                alert("결제 실패");
            }
        });
    });
}
function createOrder(quantity, amount) {
    var orderRequest = {
        quantity: quantity,
        totalPrice: amount
    };

    $.ajax({
        type: 'POST',
        url: '/api/products/' + buyerProductId +'/orders',
        contentType: 'application/json',
        data: JSON.stringify(orderRequest),
        success: function (response) {
            alert('주문이 완료되었습니다.');
            console.log(orderId)
        },
        error: function (error) {
            console.error(error);
        }
    });
}