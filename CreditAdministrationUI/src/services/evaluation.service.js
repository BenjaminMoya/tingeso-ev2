import axios from "axios";

const create = (creditId) => {
    return axios.post('/evaluation/save/', {evaluationId: null, evaluationCreditId: creditId, evaluationRelationCi: 0, evaluationRelationDi: 0});
}

const getByCreditId = (id) => {
    return axios.get(`/evaluation/getByCreditId/${id}`);
}

const relationCi = (creditId, monthlyAmount, monthlyEntry) => {
    console.log("relationCi", creditId, monthlyAmount, monthlyEntry);
    return axios.get(`/evaluation/relationCI/${creditId}/${monthlyAmount}/${monthlyEntry}`);
}

const relationDi = (creditId, monthlyAmount, debtsMonthlyAmount, creditMonthlyAmount) => {
    console.log("relationDi", creditId, monthlyAmount, debtsMonthlyAmount, creditMonthlyAmount);    
    return axios.get(`/evaluation/relationDI/${creditId}/${monthlyAmount}/${debtsMonthlyAmount}/${creditMonthlyAmount}`);
}

const min = (id, amount) => {
    return axios.post(`/evaluation/min/${id}/${amount}`);
};

const history = (id,great) => {
    return axios.post(`/evaluation/history/${id}/${great}`);
}

const periodic = (id,deposit,entry,periodic) => {
    return axios.post(`/evaluation/periodic/${id}/${deposit}/${entry}/${periodic}`);
}

const relation = (id,amount) => {
    return axios.post(`/evaluation/relation/${id}/${amount}`);
}

const out = (id,max) => {
    return axios.post(`/evaluation/out/${id}/${max}`);
}

export default { create, getByCreditId, relationCi, relationDi, min, history, periodic, relation, out };