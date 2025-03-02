#!/usr/bin/env bash

MVN_ARGS=(\
  -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn \
  -Dit-archetype-tests-skip=true \
)

# args parsing inspired by https://gist.github.com/jehiah/855086
while [ "$1" != "" ]; do
  PARAM=`echo $1 | awk -F= '{print $1}'`
  VALUE=`echo $1 | awk -F= '{print $2}'`
  case $PARAM in
    -h | --help)
      echo "Perform Maven build for xtext-xtend"
      echo ""
      echo "./1-maven-build.sh"
      echo -e "\t-h --help"
      echo -e "\t--no-tests Skip test execution"
      echo -e "\t--local-repository=<PATH> Use local Maven repository"
      echo -e "\t--tp=$TARGET_PLATFORM (valid values: r202203,r202206,...,latest)"
      echo ""
      exit
      ;;
    --no-tests)
      MVN_ARGS+=(-DskipTests=true)
      ;;
    --local-repository)
      MVN_ARGS+=" -Dmaven.repo.local=$VALUE"
      ;;
    --tp)
      MVN_ARGS+=" -Dtarget-platform-classifier=xtext-$VALUE"
      ;;
    *)
      # append any additionally passed arg
      if [ -z "$VALUE" ]; then
        MVN_ARGS+=($PARAM)
      else
        MVN_ARGS+=($PARAM=$VALUE)
      fi
      ;;
  esac
  shift
done

MVN_ARGS+=(-PuseJenkinsSnapshots)

echo mvn -B -f org.eclipse.xtext.full.releng ${MVN_ARGS[@]} $@

mvn -B \
  -f org.eclipse.xtext.full.releng \
  clean deploy \
  ${MVN_ARGS[@]} \
  $@
