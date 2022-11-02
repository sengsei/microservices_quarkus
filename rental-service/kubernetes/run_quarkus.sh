#!/bin/bash

kubectl apply -f mongodb-deployment.yaml
kubectl apply -f mongodb-service.yaml 
cd ..
kubectl apply -f target/kubernetes/kubernetes.yml
cd ..
cd rental
kubectl apply -f target/kubernetes/kubernetes.yml
cd ..
cd comment
cd comment
kubectl apply -f target/kubernetes/kubernetes.yml
sleep 5
kubectl port-forward deployment.apps/app 8080:8080
kubectl port-forward deployment.apps/app 9010
kubectl port-forward deployment.apps/rental 9011
kubectl port-forward deployment.apps/comment 9012
