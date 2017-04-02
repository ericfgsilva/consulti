#!/usr/bin/env bash

# update apt
echo '>>>>>> sudo apt-get update'
sudo apt-get update

# update curl
echo '>>>>>> Instalando o ejabberd'
sudo apt-get install ejabberd -y

# copy cfg
echo '>>>>>> Realizando backup'
sudo scp /etc/ejabberd/ejabberd.cfg /etc/ejabberd/ejabberd.cfg.bkp
sudo scp /vagrant/ejabberd.cfg /etc/ejabberd/ejabberd.cfg

echo '>>>>>> Inicializando ejabberd'
sudo service ejabberd restart

# added admin
echo '>>>>>> por favor incluir usuário admin:'
echo 'sudo ejabberdctl register admin localhost password'
#sudo ejabberdctl register admin localhost password