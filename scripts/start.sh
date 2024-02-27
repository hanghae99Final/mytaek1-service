JAR="/application.jar"

chmod +x /var/log/aws/codedeploy-agent/

APP_LOG="/var/log/aws/codedeploy-agent/application.log"
ERROR_LOG="/var/log/aws/codedeploy-agent/error.log"
START_LOG="/var/log/aws/codedeploy-agent/start.log"

NOW=$(date +%c)

echo "[$NOW] $JAR 복사" >> $START_LOG
cp /home/ubuntu/build/libs/mytaek1-0.0.1-SNAPSHOT.jar $JAR

echo "[$NOW] > $JAR 실행" >> $START_LOG
nohup java -jar $JAR > $APP_LOG 2> $ERROR_LOG &

SERVICE_PID=$(pgrep -f $JAR)
echo "[$NOW] > 서비스 PID: $SERVICE_PID" >> $START_LOG
