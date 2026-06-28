def call(String CredentialsName, String DockerhubAcc, String RegName)
 {
   withCredentials([ usernamePassword(credentialsId: CredentialsName , usernameVariable: 'DOCKER_USER',  passwordVariable: 'DOCKER_PASS' )])
 {
        sh """
                  echo "\${DOCKER_PASS}" | docker login -u "\${DOCKER_USER}"  --password-stdin
                  docker build -t "${DockerhubAcc}/${RegName}:${BUILD_NUMBER}" .
                  docker push "${DockerhubAcc}/${RegName}:${BUILD_NUMBER}" 
             """
    }
}
