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


4. goto yocto build directory
   "bitbkae -c clean uclibc"
   "bitbkae -c clean tsock"
   "bitbkae -c cleanall image-full"
   "bitbake image-full"


once build is ready download the image to clanton 

5. Login into clandon
   "cd /etc"
   "copy tsocks.conf into /etc"
   "LD_PRELOAD=/usr/lib/libtsocks.so"

6. Now we are ready to bypass the firewall


