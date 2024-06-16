# 베이스 이미지로 공식 Redis 이미지를 사용
FROM redis:latest

# 로컬 설정 파일을 컨테이너의 특정 경로로 복사
COPY redis.conf /usr/local/etc/redis/redis.conf

# Redis 서버를 커스텀 설정 파일과 함께 실행
CMD ["redis-server", "/redis.conf"]