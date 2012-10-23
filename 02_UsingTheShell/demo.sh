#!/bin/bash

cat << EOF | hbase shell
disable 'users'
drop 'users'

help 'create'

create 'users' , 'info'
list
describe 'users'

put 'users', 'u1', 'info:name', 'Mr. Rogers'
get 'users', 'u1'

put 'users', 'u1', 'info:email', 'mail@rogers.com'
put 'users', 'u1', 'info:password', 'foobar'

get 'users', 'u1'

scan 'users'

EOF
