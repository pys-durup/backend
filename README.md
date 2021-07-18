# Restful 게시판 

## 주제
간단한 게시판 구현하기

## 기술 스택 및 라이브러리
- Spring boot
- Spring Data JPA
- Mysql
- lombok

## Restful API
### POST

- 글 목록 GET /boards
- 글 읽기 GET /boards/{id}
- 글 생성 POST /boards
- 글 수정 PATCH /boards/{id}
- 글 삭제 DELETE /boards/{id}

### COMMENT

- 댓글 목록 GET /boards/{id}/comments
- 댓글 생성 POST /boards/{id}/comment
- 댓글 수정 PATCH /boards/{id}/comment/{id}
- 댓글 삭제 DELETE /boards/{id}/comment/{id}
