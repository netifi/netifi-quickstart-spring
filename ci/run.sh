GIT_SSH_COMMAND="ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no" git clone --single-branch -b master ssh://git@github.com:netifi/quickstarts-smoke-test.git runner2
cd runner2
./gradlew app:runMain --args 'netifi/proteus:latest https://github.com/netifi/proteus-spring-quickstart/ci'
cd ..
rm -rf runner2