const chai = require('chai')
const expect = require('chai').expect
const addContext = require('mochawesome/addContext');
const beerSchema = require('./schema/beers.json')

chai.use(require('chai-http'))
chai.use(require('chai-json-schema'))

const URL = 'https://api.punkapi.com/v2'

describe('Testing number of data', () => {
    it('it should be match the request param', function(done){
        var _this = this
        const numberOfData = [20, 5, 1]
        for(const item of numberOfData) {
            chai.request(URL)
                .get(`/beers?page=2&per_page=${item}`)
                .end((err, res) => {
                    expect(res.body).to.have.lengthOf(item)
                })        
            }
        done()
    })
})

describe('/beers', () => {
    it('it should have beers schemas', function(done){
        chai.request(URL)
            .get('/beers')
            .end((err, res) => {
                expect(res.body).to.be.jsonSchema(beerSchema)
                done()
            })
    })
    it('it should return all beers data ', function(done){
        chai.request(URL)
            .get('/beers')
            .end((err, res) => {
                expect(res.body).to.have.lengthOf.above(0)
                console.info(`amount of data: ${res.body.length}`)
                addContext(this, {
                    title: 'amount of data',
                    value: res.body.length
                })
                done()
            })
    });
    it('return all name', function(done){
        var name = []
        chai.request(URL)
            .get('/beers')
            .end((err, res) => {
                for (item of res.body) {
                    name.push(item.name)
                }
                console.log(`returned name : ${name.join()}`)
                addContext(this, {
                    title: 'returned name',
                    value: name.join()
                })
                done()
            })
    })
})


