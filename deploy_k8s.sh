eval $(minikube -p minikube docker-env)
kubectl create namespace fraude
mvn clean package -Dquarkus.kubernetes.deploy=true