GIT_SSH_COMMAND="ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no" git clone --single-branch -b master git@github.com:netifi/quickstarts-smoke-test.git runner
cd runner
./gradlew app:runMain --args 'netifi/proteus:latest https://github.com/netifi/proteus-spring-quickstart/ci'
cd ..
rm -rf runner