const chai = require('chai')
const expect = require('chai').expect
const beerSchema = require('./schema/beers.json')

chai.use(require('chai-http'))
chai.use(require('chai-json-schema'))

const URL = 'https://api.punkapi.com/v2'

describe('Testing number of data', () => {
    it('it should be match the request param', (done) => {
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
    it('it should have beers schemas', (done) => {
        chai.request(URL)
            .get('/beers')
            .end((err, res) => {
                expect(res.body).to.be.jsonSchema(beerSchema)
                done()
            })
    })
    it('it should return all beers data ', (done) => {
        chai.request(URL)
            .get('/beers')
            .end((err, res) => {
                expect(res.body).to.have.lengthOf.above(0)
                console.info(`amount of data: ${res.body.length}`)
                allure.description(`amount of data: ${res.body.length}`)
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
                allure.description(`Returned name: ${name.join()}`)
                console.log(`returned name : ${name.join()}`)
                done()
            })
    })
})


