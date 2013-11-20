tsocks
======
These instruction are to make the new poky build with tsocks that will enable to bypass the firewall for clanton build


1. add the below string into the folling file:
   meta-clanton_v0.7.5/meta-clanton-distro/recipes-core/images/image-full.bb
   IMAGE_INSTALL += "tsocks"

2. go to /home/akuma34/work/clanton/meta-clanton_v0.7.5/poky/meta/recipes-core/uclibc/uclibc-git/uClibs.distro
   Add the follwing lines into this file
   LDSO_PRELOAD_FILE_SUPPORT=y
   LDSO_PRELOAD_ENV_SUPPORT=y

3. go to meta-clanton_v0.7.5/meta-clanton-distro/recipes-extended
   "mkdir tsocks"
   "cd tsocks"
   add the tsocks.bb file to this directory

4. Please source the env file "source poky/oe-init-build-env <your build dir. >"


5. goto yocto build or <your build dir.> directory
   "bitbake -c clean uclibc"
   "bitbake -c clean tsock"
   "bitbake -c cleanall image-full"
   "bitbake image-full"


once build is ready download the image to clanton 

6. Login into clandon
   "cd /etc"
   "copy tsocks.conf into /etc"
   please edit the tsocks.conf file to add your proxy server setting in it.
   "LD_PRELOAD=/usr/lib/libtsocks.so"

7. Now we are ready to bypass the firewall


