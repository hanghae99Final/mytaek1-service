package org.sparta.mytaek1.global.message;

public enum ErrorMessage {

    NOT_EXIST_TOKEN_ERROR_MESSAGE("토큰을 찾을 수 없습니다."),
    NOT_EXIST_USER_ERROR_MESSAGE("존재하지 않는 사용자입니다."),
    NOT_EXIST_EMAIL_ERROR_MESSAGE("존재하지 않는 이메일입니다."),
    EXIST_ON_AIR_BROADCAST_ERROR_MESSAGE("이미 존재하는 방송입니다."),
    NOT_EXIST_STREAM_KEY_ERROR_MESSAGE("존재하지 않는 스트림 키입니다."),
    NOT_EXIST_BROADCAST_ERROR_MESSAGE("존재하지 않는 방송입니다."),
    NOT_EXIST_PRODUCT_ERROR_MESSAGE("존재하지 않는 상품입니다."),
    NOT_EXIST_STOCK_ERROR_MESSAGE("재고가 없습니다."),
    NOT_EXIST_ORDER_ERROR_MESSAGE("재고가 없습니다."),
    PASSWORD_MISMATCH_ERROR_MESSAGE("로그인에 실패하였습니다."),
    AUTH_EXCEPTION_MESSAGE("로그인 해야 가능한 기능입니다."),
    LOCK_NOT_ACQUIRED_ERROR_MESSAGE("락을 획득하지 못했습니다. 잠시 후 다시 시도해주세요."),
    INVALID_FILE_FORMAT_FILE_TYPE_ERROR_MESSAGE("잘못된 형식의 파일입니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return "[ERROR] " + errorMessage;
    }
}
