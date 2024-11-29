import httpCommon from '../http-common';
import axios from "axios";
const getAll = () => {
  return httpCommon.get('/user/get');
}

const getById = (id) => {
  return httpCommon.get(`/user/getById/${id}`);
}

const getByRut = (rut) => {
  return httpCommon.get(`/user/getByRut/${rut}`);
}

const getByEmail = (email) => {
  return httpCommon.get(`/user/getByEmail/${email}`);
}

const create = (data) => {
  return httpCommon.post('/user/save', data);
}

const login = (data) => {
  return httpCommon.post('/user/login', data);
}

const update = (data) => {
    return httpCommon.put('/user/update', data);
}

const remove = (id) => {
    return httpCommon.delete(`/user/delete/${id}`);
}

const zero = (id) => {
    return httpCommon.post(`/user/zero/${id}`);
}

const transfer = (userId,creditId) => {
    return httpCommon.post("/user/transfer",{ userId, creditId});
}

export default { getAll, getById, getByRut, getByEmail, create, login, update, remove, zero, transfer };