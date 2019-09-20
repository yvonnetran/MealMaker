package hu.ait.mf.data

// result generated from /json

data class RecipeResult(val q: String?, val from: Number?, val to: Number?, val params: Params?, val more: Boolean?, val count: Number?, val hits: List<Hits>?)

data class CA(val label: String?, val quantity: Number?, val unit: String?)

data class CHOCDF(val label: String?, val quantity: Number?, val unit: String?)

data class CHOLE(val label: String?, val quantity: Number?, val unit: String?)

data class Digest1225371987(val label: String?, val tag: String?, val schemaOrgTag: String?, val total: Number?, val hasRDI: Boolean?, val daily: Number?, val unit: String?, val sub: List<Any>?)

data class Digest1412816451(val label: String?, val tag: String?, val schemaOrgTag: String?, val total: Number?, val hasRDI: Boolean?, val daily: Number?, val unit: String?, val sub: List<Any>?)

data class Digest1761614095(val label: String?, val tag: String?, val schemaOrgTag: String?, val total: Number?, val hasRDI: Boolean?, val daily: Number?, val unit: String?, val sub: List<Any>?)

data class ENERC_KCAL(val label: String?, val quantity: Number?, val unit: String?)

data class FAMS(val label: String?, val quantity: Number?, val unit: String?)

data class FAPU(val label: String?, val quantity: Number?, val unit: String?)

data class FASAT(val label: String?, val quantity: Number?, val unit: String?)

data class FAT(val label: String?, val quantity: Number?, val unit: String?)

data class FATRN(val label: String?, val quantity: Number?, val unit: String?)

data class FE(val label: String?, val quantity: Number?, val unit: String?)

data class FIBTG(val label: String?, val quantity: Number?, val unit: String?)

data class FOLDFE(val label: String?, val quantity: Number?, val unit: String?)

data class FOLFD(val label: String?, val quantity: Number?, val unit: String?)

data class Hits(val recipe: Recipe?, val bookmarked: Boolean?, val bought: Boolean?)

data class Ingredients1629929993(val text: String?, val weight: Number?)

data class Ingredients521149042(val text: String?, val weight: Number?)

data class Ingredients655827347(val text: String?, val weight: Number?)

data class K(val label: String?, val quantity: Number?, val unit: String?)

data class MG(val label: String?, val quantity: Number?, val unit: String?)

data class NA(val label: String?, val quantity: Number?, val unit: String?)

data class NIA(val label: String?, val quantity: Number?, val unit: String?)

data class P(val label: String?, val quantity: Number?, val unit: String?)

data class PROCNT(val label: String?, val quantity: Number?, val unit: String?)

data class Params(val sane: List<Any>?, val q: List<String>?, val app_key: List<String>?, val health: List<String>?, val from: List<String>?, val to: List<String>?, val calories: List<String>?, val app_id: List<String>?)

data class RIBF(val label: String?, val quantity: Number?, val unit: String?)

data class Recipe(val uri: String?, val label: String?, val image: String?, val source: String?, val url: String?, val shareAs: String?, val yield: Number?, val dietLabels: List<String>?, val healthLabels: List<String>?, val cautions: List<String>?, val ingredientLines: List<String>?, val ingredients: List<Ingredients1629929993>?, val calories: Number?, val totalWeight: Number?, val totalTime: Number?, val totalNutrients: TotalNutrients?, val totalDaily: TotalDaily?, val digest: List<Any>?)

data class SUGAR(val label: String?, val quantity: Number?, val unit: String?)

data class Sub1282393884(val label: String?, val tag: String?, val schemaOrgTag: String?, val total: Number?, val hasRDI: Boolean?, val daily: Number?, val unit: String?)

data class Sub15342016(val label: String?, val tag: String?, val schemaOrgTag: String?, val total: Number?, val hasRDI: Boolean?, val daily: Number?, val unit: String?)

data class Sub2115471925(val label: String?, val tag: String?, val schemaOrgTag: String?, val total: Number?, val hasRDI: Boolean?, val daily: Number?, val unit: String?)

data class Sub251575917(val label: String?, val tag: String?, val schemaOrgTag: String?, val total: Number?, val hasRDI: Boolean?, val daily: Number?, val unit: String?)

data class Sub322301976(val label: String?, val tag: String?, val schemaOrgTag: String?, val total: Number?, val hasRDI: Boolean?, val daily: Number?, val unit: String?)

data class Sub494636449(val label: String?, val tag: String?, val schemaOrgTag: String?, val total: Number?, val hasRDI: Boolean?, val daily: Number?, val unit: String?)

data class THIA(val label: String?, val quantity: Number?, val unit: String?)

data class TOCPHA(val label: String?, val quantity: Number?, val unit: String?)

data class TotalDaily(val ENERC_KCAL: ENERC_KCAL?, val FAT: FAT?, val FASAT: FASAT?, val CHOCDF: CHOCDF?, val FIBTG: FIBTG?, val PROCNT: PROCNT?, val CHOLE: CHOLE?, val NA: NA?, val CA: CA?, val MG: MG?, val K: K?, val FE: FE?, val ZN: ZN?, val P: P?, val VITA_RAE: VITA_RAE?, val VITC: VITC?, val THIA: THIA?, val RIBF: RIBF?, val NIA: NIA?, val VITB6A: VITB6A?, val FOLDFE: FOLDFE?, val VITB12: VITB12?, val VITD: VITD?, val TOCPHA: TOCPHA?, val VITK1: VITK1?)

data class TotalNutrients(val ENERC_KCAL: ENERC_KCAL?, val FAT: FAT?, val FASAT: FASAT?, val FATRN: FATRN?, val FAMS: FAMS?, val FAPU: FAPU?, val CHOCDF: CHOCDF?, val FIBTG: FIBTG?, val SUGAR: SUGAR?, val PROCNT: PROCNT?, val CHOLE: CHOLE?, val NA: NA?, val CA: CA?, val MG: MG?, val K: K?, val FE: FE?, val ZN: ZN?, val P: P?, val VITA_RAE: VITA_RAE?, val VITC: VITC?, val THIA: THIA?, val RIBF: RIBF?, val NIA: NIA?, val VITB6A: VITB6A?, val FOLDFE: FOLDFE?, val FOLFD: FOLFD?, val VITB12: VITB12?, val VITD: VITD?, val TOCPHA: TOCPHA?, val VITK1: VITK1?)

data class VITA_RAE(val label: String?, val quantity: Number?, val unit: String?)

data class VITB12(val label: String?, val quantity: Number?, val unit: String?)

data class VITB6A(val label: String?, val quantity: Number?, val unit: String?)

data class VITC(val label: String?, val quantity: Number?, val unit: String?)

data class VITD(val label: String?, val quantity: Number?, val unit: String?)

data class VITK1(val label: String?, val quantity: Number?, val unit: String?)

data class ZN(val label: String?, val quantity: Number?, val unit: String?)
