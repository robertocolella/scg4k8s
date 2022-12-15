# INSTALL WITH TANZU CLI 

## PREREQUISTE
### KAPP CONTROLLER

    kapp deploy -a kc -f https://github.com/vmware-tanzu/carvel-kapp-controller/releases/latest/download/release.yml

### SECGEN CONTROLLER

    kapp deploy -a sg -f https://github.com/vmware-tanzu/carvel-secretgen-controller/releases/latest/download/release.yml



kubectl create namespace tap-install

tanzu secret registry add tap-registry \
    --namespace tap-install \
    --server "registry.tanzu.vmware.com" \
    --username "{registry username}" \
    --password "{registry password}" \
    --export-to-all-namespaces

    tanzu secret registry add tap-registry \
        --namespace tap-install \
        --server "registry.tanzu.vmware.com" \
        --username 'colellar@vmware.com' \
        --password 'e3$iKJLUTJQkv28' \
        --export-to-all-namespaces


scg-package-repository-fetch-0

tanzu secret registry list --namespace tap-install

tanzu package repository add scg-package-repository \
    --namespace tap-install \
    --url registry.tanzu.vmware.com/spring-cloud-gateway-for-kubernetes/scg-package-repository:{version}

    tanzu package repository add scg-package-repository \
        --namespace tap-install \
        --url registry.tanzu.vmware.com/spring-cloud-gateway-for-kubernetes/scg-package-repository:1.2.0

    tanzu package repository add scg-package-repository \
        --namespace tap-install \
        --url registry.tanzu.vmware.com/spring-cloud-gateway-for-kubernetes/scg-package-repository:1.2.4

tanzu package available list --namespace tap-install


    tanzu package install spring-cloud-gateway \
        --namespace tap-install \
        --package-name spring-cloud-gateway.tanzu.vmware.com \
        --version 1.2.0

    tanzu package install spring-cloud-gateway \
        --namespace tap-install \
        --package-name spring-cloud-gateway.tanzu.vmware.com \
        --version 1.2.4

## MULTIPLE REPLICAS
tanzu package install spring-cloud-gateway \
    --namespace tap-install \
    --package-name spring-cloud-gateway.tanzu.vmware.com \
    --values-file config-with-multiple-replicas.yaml \
    --version {version}

# USE

kubectl get scg my-gateway

kubectl describe scg my-gateway
kubectl describe scgm my-gateway-mapping
kubectl describe scgrc my-gateway-route-config

